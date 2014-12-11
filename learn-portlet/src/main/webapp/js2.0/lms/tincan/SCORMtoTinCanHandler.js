/*SCORM to TinCan Handler*/


// Main function to handle SCORM commands to TinCan Statements
function SCORMtoTinCanHandler(command, parameter, value)
{
	var result = "true";

	//TODO: Check if we have a connection to the TCAPI, if not: return;

	switch (command)
    {
        case "SetValue":
            parameter = SCORM12to2004Param(parameter);
            result = S2TCSetParameter(parameter,value);
            break;
        case "GetValue":
            parameter = SCORM12to2004Param(parameter);
            result = S2TCGetParameter(parameter, value);
            break;
        case "Terminate":
            endAttemptSession();
            break;
        case "Initialize":
            startAttemptSession();
            break;
    }
	
	return result;
}

// Convert SCORM1.2 params into SCORM2004 format, because library works with SCORM2004
function SCORM12to2004Param(parameter)
{
    var new_parameter = parameter;
    switch (parameter)
    {
        case "cmi.core.lesson_status": new_parameter = "cmi.completion_status"; break;
        case "cmi.core.entry": new_parameter = "cmi.entry"; break;
        case "cmi.core.exit": new_parameter = "cmi.exit"; break;
        case "cmi.core.lesson_location": new_parameter = "cmi.location"; break;
        case "cmi.core.score.raw": new_parameter = "cmi.score.raw"; break;
        case "cmi.core.score.min": new_parameter = "cmi.score.min"; break;
        case "cmi.core.score.max": new_parameter = "cmi.score.max"; break;
        case "cmi.core.score.scaled": new_parameter = "cmi.score.scaled"; break;
        case "cmi.core.session_time": new_parameter = "cmi.session_time"; break;
    }
    return new_parameter;
}

function S2TCSetParameter(parameter,value)
{
	switch (parameter)
	{
	case "cmi.exit": //(timeout, suspend, logout, normal, "", WO) Indicates how or why the learner left the SCO
		break;
	case "cmi.score.scaled": // score as a decimal
	case "cmi.score.min": // Minimum value in the range for the raw score.
	case "cmi.score.max": // Maximum possible score.
	case "cmi.score.raw": // Points score so far by the learner		
	case "cmi.success_status": // ('passed', 'failed', 'unknown', RW) Indicates whether the learner has mastered the SCO
    case "cmi.location":
            //Just update the cache to pass later
        //Add the value to the cache and update the state
        cacheParameter(parameter,value);

        break;
        case "cmi.session_time": //time interval.  Amount of time that the learner has spent in the current learner session for this SCO
		//e.g. "PT0H0M7S"
		
		//update session duration
		cacheParameter(parameter,value);
		
		//Update the attempt duration
        try{
		var newAttemptDuration = convertSecondsToCMITimespan(convertCMITimespanToSeconds(initialDuration) + convertCMITimespanToSeconds(offsetDuration) + convertCMITimespanToSeconds(value));
		cacheParameter("cmi.total_time",newAttemptDuration);
        } catch (e) {
            "<undefined/>";
        }
	    break;
    case "cmi.completion_status": // ('completed', 'incomplete', 'not attempted', 'unknown', RW) Indicates whether the learner has completed the SCO
		// 'failed' and 'passed' for SCORM 1.2
		//Only send the data if it has changed
		//Only send value to LRS if it hasn't already been sent;
		//If value is cached and matches what is about to be sent
		//to the LRS, prevent value from being sent a second time.
		if((cacheParameter(parameter,value)) && (
            (value == "completed") || (value == "failed") || (value == "passed"))) {
		   resultChanged = true;
		} 					
	
		break;
	case "cmi.suspend_data": //Suspend Data string
        //save the data
        cacheParameter(parameter,value);
        SendState();

        //Check if completion status changed in this batch of SCORM calls
        if (resultChanged)
        {
            resultChanged = false;
            SendAttemptData();
        }
        break;
	default:
        var parameterArray = new Array();
        var parameterStr = parameter.replace('..', '.0.');
        parameterArray = parameterStr.split('.');
		if (parameterArray[1] == "interactions")    // interactions
		{
			//Handle interactions
			var interaction_index = parameterArray[2],
			interaction_parameter = parameterArray[3];
			
			switch(interaction_parameter)
			{
				case "id": //Unique label for the interaction
				case "timestamp": //Point in time at which the interaction was first made available to the learner for learner interaction and response
				case "type": // ('true-false', 'choice', 'fill-in', 'long-fill-in', 'matching', 'performance', 'sequencing', 'likert', 'numeric' or 'other') Which type of interaction is recorded
				case "weighting": //How many points the question is worth
				case "learner_response": //Data generated when a learner responds to an interaction
				case "result": // ('correct', 'incorrect', 'unanticipated', 'neutral') or a real number with values that is accurate to seven significant decimal figures real.)  Judgment of the correctness of the learner response
					cacheParameter(parameter,value);
					break;
				case "latency": //(timeinterval (second,10,2), RW) Time elapsed between the time the interaction was made available to the learner for response and the time of the first response
					//Note: I.e. Time taken to answer the question, not (as you might think) the lag the learner was experiencing at the time of the interaction (though this would include lag)! 
					//Consider reporting "since" and "until" using timestamp and latency data from the SCORMDataCache
					
					cacheParameter(parameter,value);

					SendInteractionData(interaction_index);
					
					break;
					
				case "description": //Description of the interaction
				case "objectives._count": //(non-negative integer) Current number of objectives (i.e., objective identifiers) being stored by the LMS for this interaction
					cacheParameter(parameter,value);
					break;
				default:
				if (interaction_parameter == "correct_responses")
				{
					var interaction_correct_responses_index = parseInt(parameterArray[4]),
					interaction_correct_responses_parameter = parameterArray[5];
					switch(interaction_correct_responses_parameter)
					{
						case "pattern":  // (format depends on interaction type) One correct response pattern for the interaction
							cacheParameter(parameter,value);
							break;
						default:
						myTinCan.log("Unexpected interaction correct_responses parameter: '" + parameter +"' with value: '" + value +"'");
					}
				}
				else if (interaction_parameter == "objectives")
				{
					var interaction_objectives_index = parameterArray[4],
					interaction_objectives_parameter = parameterArray[5];
					switch(interaction_objectives_parameter)
					{
						case "id":  //(long_identifier_type (SPM: 4000), RW) Label for objectives associated with the interaction
							break;
						default:
						myTinCan.log("Unexpected interaction objectives parameter: '" + parameter +"' with value: '" + value +"'");
					}
				}
				else
				{
					myTinCan.log("Unexpected interaction parameter: '" + parameter +"' with value: '" + value +"'");
				}
			}
		}
		else
		{
			myTinCan.log("Unexpected parameter: '" + parameter + "' with value: '" + value +"'");
		}
	}
	return "true";
}


function S2TCGetParameter(parameter, defaultValue)
{
	switch (parameter)
	{
	case "cmi.entry": // (ab_initio, resume, '') Asserts whether the learner has previously accessed the SCO
		var entryState = GetFromStore("cmi.entry");
		//Next time the user loads this activity, cmi.entry tells that they have accessed this before.
		cacheParameter("cmi.entry","resume");
		return entryState;
		break;
	case "cmi.location": // location
	case "cmi.suspend_data": //Suspend Data string - must be returned exactly as it was set last attempt. Default is ''.
		return GetFromStore(parameter);
		break;
	case "cmi.score._children"://(scaled,raw,min,max) Listing of supported data model elements.
		//SCORM cloud returns 'scaled,min,max,raw'. TCAPI explicitly supports all 4.
		return 'scaled,min,max,raw';
		break;
	case "cmi.interactions._children": //(id,type,objectives,timestamp,correct_responses,weighting,learner_response,result,latency,description) Listing of supported data model elements
		return 'id,type,objectives,timestamp,correct_responses,weighting,learner_response,result,latency,description';
		break;
	case "cmi.score.scaled": // score as a decimal
	case "cmi.score.min": //Minimum value in the range for the raw score.
	case "cmi.score.max": //Max possible score.
	case "cmi.score.raw": //Points score so far by the learner
		return GetFromStore(parameter);
		break;
	default:
		myTinCan.log("Unexpected parameter: " + parameter);
        return defaultValue;
	}
	
	//If we haven't yet returned anything:
	return GetFromStore(parameter);
}

function attemptCompleted()
{
	SendAttemptData();
}

function endAttemptSession()
{
    if (currentPackageID == -1) return;
    SendAttemptData();
    initialized = false;
    myTinCan.activity = null;
}

function startAttemptSession()
{
    if(initialized)
        SendAttemptData();
    ResetInteractionIndex();
    InitVars();
}




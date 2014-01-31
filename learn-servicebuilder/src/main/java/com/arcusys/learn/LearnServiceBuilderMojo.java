package com.arcusys.learn;

import com.liferay.maven.plugins.ServiceBuilderMojo;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectBuilder;
import org.apache.maven.shared.invoker.Invoker;
import org.codehaus.plexus.archiver.manager.ArchiverManager;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mkapitonov
 * Date: 19.12.2013
 * Time: 14.09
 * Builds Liferay Service Builder services for project Learn
 */

@Mojo(name = "build-service", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class LearnServiceBuilderMojo extends ServiceBuilderMojo {

    @Override
    public void execute() throws MojoExecutionException {
        /* HACK: Set the parameters of ServiceBuilderMojo */
        setPrivateField(ServiceBuilderMojo.class, "apiBaseDir", apiBaseDir);
        setPrivateField(ServiceBuilderMojo.class, "apiDir", apiDir);
        setPrivateField(ServiceBuilderMojo.class, "autoNamespaceTables", autoNamespaceTables);
        setPrivateField(ServiceBuilderMojo.class, "baseDir", baseDir);
        setPrivateField(ServiceBuilderMojo.class, "beanLocatorUtil", beanLocatorUtil);
        setPrivateField(ServiceBuilderMojo.class, "hbmFileName", hbmFileName);
        setPrivateField(ServiceBuilderMojo.class, "implBaseDir", implBaseDir);
        setPrivateField(ServiceBuilderMojo.class, "implDir", implDir);
        setPrivateField(ServiceBuilderMojo.class, "implResourcesDir", implResourcesDir);
        setPrivateField(ServiceBuilderMojo.class, "invoker", invoker);
        setPrivateField(ServiceBuilderMojo.class, "jsonFileName", jsonFileName);
        setPrivateField(ServiceBuilderMojo.class, "modelHintsFileName", modelHintsFileName);
        setPrivateField(ServiceBuilderMojo.class, "ormFileName", ormFileName);
        setPrivateField(ServiceBuilderMojo.class, "pluginName", pluginName);
        setPrivateField(ServiceBuilderMojo.class, "pluginType", pluginType);
        setPrivateField(ServiceBuilderMojo.class, "postBuildDependencyModules", postBuildDependencyModules);
        setPrivateField(ServiceBuilderMojo.class, "postBuildGoals", postBuildGoals);
        setPrivateField(ServiceBuilderMojo.class, "propsUtil", propsUtil);
        setPrivateField(ServiceBuilderMojo.class, "remotingFileName", remotingFileName);
        setPrivateField(ServiceBuilderMojo.class, "serviceBuildNumber", serviceBuildNumber);
        setPrivateField(ServiceBuilderMojo.class, "serviceBuildNumberIncrement", serviceBuildNumberIncrement);
        setPrivateField(ServiceBuilderMojo.class, "serviceFileName", serviceFileName);
        setPrivateField(ServiceBuilderMojo.class, "springBaseFileName", springBaseFileName);
        setPrivateField(ServiceBuilderMojo.class, "springClusterFileName", springClusterFileName);
        setPrivateField(ServiceBuilderMojo.class, "springDynamicDataSourceFileName", springDynamicDataSourceFileName);
        setPrivateField(ServiceBuilderMojo.class, "springFileName", springFileName);
        setPrivateField(ServiceBuilderMojo.class, "springHibernateFileName", springHibernateFileName);
        setPrivateField(ServiceBuilderMojo.class, "springInfrastructureFileName", springInfrastructureFileName);
        setPrivateField(ServiceBuilderMojo.class, "springShardDataSourceFileName", springShardDataSourceFileName);
        setPrivateField(ServiceBuilderMojo.class, "sqlDir", sqlDir);
        setPrivateField(ServiceBuilderMojo.class, "sqlFileName", sqlFileName);
        setPrivateField(ServiceBuilderMojo.class, "sqlIndexesFileName", sqlIndexesFileName);
        setPrivateField(ServiceBuilderMojo.class, "sqlIndexesPropertiesFileName", sqlIndexesPropertiesFileName);
        setPrivateField(ServiceBuilderMojo.class, "sqlSequencesFileName", sqlSequencesFileName);
        setPrivateField(ServiceBuilderMojo.class, "targetEntityName", targetEntityName);
        setPrivateField(ServiceBuilderMojo.class, "webappBaseDir", webappBaseDir);

        /* HACK: Set the parameters of AbstractLiferayMojo */
        super.appServerClassesPortalDir = appServerClassesPortalDir;
        super.appServerLibGlobalDir = appServerLibGlobalDir;
        super.appServerLibPortalDir = appServerLibPortalDir;
        super.appServerPortalDir = appServerPortalDir;
        super.appServerTldPortalDir = appServerTldPortalDir;
        super.archiverManager = archiverManager;
        super.artifactFactory = artifactFactory;
        super.artifactResolver = artifactResolver;
        super.liferayVersion = liferayVersion;
        super.localArtifactRepository = localArtifactRepository;
        super.project = project;
        super.projectBuilder = projectBuilder;
        super.remoteArtifactRepositories = remoteArtifactRepositories;
        super.workDir = workDir;

        super.execute();
    }

    @Override
    protected List<String> getProjectClassPath() throws Exception {
        List<String> entryList = super.getProjectClassPath();

        // Add mojo class code source in the beginning so we will could override ServiceBuilder class definition
        entryList.add(0, this.getClass().getProtectionDomain().getCodeSource().getLocation().toExternalForm());

        return entryList;
    }

    private void setPrivateField(Class c, String fieldName, Object value) {
        try {
            Field field = c.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(this, value);
            field.setAccessible(false);
        } catch (Exception ignored) {}
    }

    /**
     * Parameters brought over from ServiceBuilderMojo
     *
     * */

    @Parameter
    private String apiBaseDir;

    @Parameter
    private String apiDir;

    @Parameter(defaultValue = "true", required = true)
    private boolean autoNamespaceTables;

    @Parameter(defaultValue = "${basedir}", required = true)
    private String baseDir;

    @Parameter
    private String beanLocatorUtil;

    @Parameter
    private String hbmFileName;

    @Parameter
    private String implBaseDir;

    @Parameter
    private String implDir;

    @Parameter
    private String implResourcesDir;

    @Component
    private Invoker invoker;

    /**
     * @deprecated As of 6.2.0
     */
    @Parameter
    private String jsonFileName;

    @Parameter
    private String modelHintsFileName;

    @Parameter
    private String ormFileName;

    @Parameter(defaultValue = "${project.artifactId}", required = true)
    private String pluginName;

    @Parameter(defaultValue = "${pluginType}", required = true)
    private String pluginType = "portlet";

    /**
     * @deprecated As of 6.1.0
     */
    @Parameter(defaultValue = "${postBuildDependencyModules}")
    private boolean postBuildDependencyModules = false;

    /**
     * @deprecated As of 6.1.0
     */
    @Parameter
    private List<String> postBuildGoals;

    @Parameter
    private String propsUtil;

    @Parameter
    private String remotingFileName;

    @Parameter(defaultValue = "${serviceBuildNumber}")
    private long serviceBuildNumber = 1;

    @Parameter(defaultValue = "${serviceBuildNumberIncrement}")
    private boolean serviceBuildNumberIncrement = true;

    @Parameter(defaultValue = "${serviceFileName}")
    private String serviceFileName = "";

    @Parameter
    private String springBaseFileName;

    @Parameter
    private String springClusterFileName;

    /**
     * @deprecated As of 6.1.0
     */
    @Parameter
    private String springDynamicDataSourceFileName;

    @Parameter
    private String springFileName;

    @Parameter
    private String springHibernateFileName;

    @Parameter
    private String springInfrastructureFileName;

    @Parameter
    private String springShardDataSourceFileName;

    @Parameter
    private String sqlDir;

    @Parameter
    private String sqlFileName;

    @Parameter(defaultValue = "indexes.sql")
    private String sqlIndexesFileName;

    @Parameter(defaultValue = "indexes.properties", required = true)
    private String sqlIndexesPropertiesFileName;

    @Parameter(defaultValue = "sequence.sql", required = true)
    private String sqlSequencesFileName;

    @Parameter
    private String targetEntityName;

    @Parameter
    private String webappBaseDir;


    /**
     * Parameters brought over from AbstractLiferayMojo
     *
     * */

    @Parameter(defaultValue = "${appServerClassesPortalDir}")
    protected File appServerClassesPortalDir;

    @Parameter(defaultValue = "${appServerLibGlobalDir}")
    protected File appServerLibGlobalDir;

    @Parameter(defaultValue = "${appServerLibPortalDir}")
    protected File appServerLibPortalDir;

    @Parameter(defaultValue = "${appServerPortalDir}")
    protected File appServerPortalDir;

    @Parameter(defaultValue = "${appServerTldPortalDir}")
    protected File appServerTldPortalDir;

    @Component
    protected ArchiverManager archiverManager;

    @Component
    protected ArtifactFactory artifactFactory;

    @Component
    protected ArtifactResolver artifactResolver;

    @Parameter(defaultValue = "${liferayVersion}")
    protected String liferayVersion;

    @Parameter(defaultValue = "${localRepository}", required = true, readonly = true)
    protected ArtifactRepository localArtifactRepository;

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    protected MavenProject project;

    @Component(role = MavenProjectBuilder.class)
    protected MavenProjectBuilder projectBuilder;

    @Parameter(defaultValue = "${project.remoteArtifactRepositories}", required = true, readonly = true)
    protected List remoteArtifactRepositories;

    @Parameter(defaultValue = "${project.build.directory}/liferay-work", required = true)
    protected File workDir;
}
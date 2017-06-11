/**
 * 
 */
package com.backbase.computers.stories;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.model.TableTransformers;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory.ResolveToPackagedName;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backbase.computers.config.ComputersApplicationConfig;

/**
 * @author viniciussilva
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ComputersApplicationConfig.class })
public abstract class AbstractStoriesRunner extends JUnitStories {

	private final CrossReference xref = new CrossReference();

//	@Autowired
//	private ApplicationContext context;

	public abstract String getStoryLocations();

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), getStoryLocations(), "");
	}

	@Override
	public Configuration configuration() {
		Class<? extends Embeddable> embeddableClass = this.getClass();
		Properties viewResources = new Properties();
		viewResources.put("decorateNonHtml", "true");

		ParameterConverters parameterConverters = new ParameterConverters(new TableTransformers());
		ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new TableTransformers());

		parameterConverters.addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd")), new ExamplesTableConverter(examplesTableFactory));

		return new MostUsefulConfiguration()
				.useStoryControls(new StoryControls().doDryRun(false).doSkipScenariosAfterFailure(false))
				.useStoryLoader(new LoadFromClasspath(embeddableClass))
				.useStoryParser(new RegexStoryParser(examplesTableFactory))
				.useStoryPathResolver(new UnderscoredCamelCaseResolver())
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass)).withDefaultFormats()
								.withPathResolver(new ResolveToPackagedName()).withViewResources(viewResources)
								.withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML).withFailureTrace(true).withFailureTraceCompression(true)
								.withCrossReference(xref)).useParameterConverters(parameterConverters)
				// use '%' instead of '$' to identify parameters
				.useStepMonitor(xref.getStepMonitor());
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new SpringStepsFactory(configuration(), new SpringApplicationContextFactory("configs/app-context.xml").createApplicationContext());
	}

}

import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

public class WebFlowTests extends AbstractXmlFlowExecutionTests {
    @Override
    protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {
    }

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory flowDefinitionResourceFactory) {
        return flowDefinitionResourceFactory.createFileResource("src/main/webapp/WEB-INF/flows/hello-flow.xml");
    }

    public void testHelloFlow() {
        MockExternalContext context = new MockExternalContext();
        startFlow(context);
        assertCurrentStateEquals("hello");
    }
}

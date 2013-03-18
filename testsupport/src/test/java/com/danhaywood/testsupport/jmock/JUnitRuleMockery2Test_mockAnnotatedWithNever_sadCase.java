package com.danhaywood.testsupport.jmock;

import org.jmock.auto.Mock;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.danhaywood.testsupport.jmock.JUnitRuleMockery2.ClassUnderTest;
import com.danhaywood.testsupport.jmock.JUnitRuleMockery2.Mode;
import com.danhaywood.testsupport.jmock.JUnitRuleMockery2.Never;

public class JUnitRuleMockery2Test_mockAnnotatedWithNever_sadCase {

    @Rule
    public ExpectedException exp = ExpectedException.none();
    
    @Rule
    public JUnitRuleMockery2 context = JUnitRuleMockery2.createFor(Mode.INTERFACES_AND_CLASSES);

    @SuppressWarnings("unused")
    @Never
    @Mock
    private Collaborator collaborator;

    @ClassUnderTest
	private CollaboratingUsingConstructorInjection collaborating;

    @Before
	public void setUp() throws Exception {
    	collaborating = context.getClassUnderTest();
	}

    @Test
    public void invocationOnCollaboratorIsIgnored() {
        exp.handleAssertionErrors().expect(AssertionError.class);
        collaborating.collaborateWithCollaborator();
    }

}

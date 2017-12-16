package aem.from.scratch.sightly;

import java.util.List;

import org.junit.Test;

public class TestGithubSightlyUse {

    private GithubSightlyUse githubSightlyUseUnderTest;

    @Test
    public void testGetRepositories() {
        List<String> githubRepositories = githubSightlyUseUnderTest.getRepositories();
    }

}

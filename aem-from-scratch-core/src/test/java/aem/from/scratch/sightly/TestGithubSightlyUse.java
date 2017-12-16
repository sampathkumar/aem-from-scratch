package aem.from.scratch.sightly;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGithubSightlyUse {

    private GithubSightlyUse githubSightlyUseUnderTest;

    @Before
    public void setup() {
        githubSightlyUseUnderTest = new GithubSightlyUse();
    }

    @Test
    public void testGetRepositories() {
        List<String> githubRepositories = githubSightlyUseUnderTest.getRepositories();
        Assert.assertNotNull(githubRepositories);
    }

    @Test
    public void testGetRepositoriesContainsTenRepos() {
        List<String> githubRepositories = githubSightlyUseUnderTest.getRepositories();
        Assert.assertNotNull(githubRepositories);
        Assert.assertEquals(10, githubRepositories.size());
    }

}

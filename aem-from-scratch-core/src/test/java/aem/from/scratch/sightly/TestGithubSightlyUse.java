package aem.from.scratch.sightly;

import java.util.List;

import org.apache.sling.testing.mock.osgi.junit.OsgiContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

public class TestGithubSightlyUse {

    @Rule
    public final OsgiContext context = new OsgiContext();

    private GithubSightlyUse githubSightlyUseUnderTest;

    @Before
    public void setup() {
        githubSightlyUseUnderTest = new GithubSightlyUse();
    }

    @Test
    public void testGetRepositoriesContainsTenRepos() {
        IGithubRepoFetcher repoFetcher = Mockito.mock(IGithubRepoFetcher.class);
        context.registerService(IGithubRepoFetcher.class, repoFetcher);
        context.registerInjectActivateService(githubSightlyUseUnderTest);
        List<String> githubRepositories = githubSightlyUseUnderTest.getRepositories();
        Assert.assertNotNull(githubRepositories);
        Assert.assertEquals(10, githubRepositories.size());
    }

}

package aem.from.scratch.sightly;

import java.util.ArrayList;
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
        IGithubRepoFetcher repoFetcher = Mockito.mock(IGithubRepoFetcher.class,
                "Mock created while testing ContainsTenRepos");
        List<String> repositories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            repositories.add("Repo:" + i);
        }
        Mockito.when(repoFetcher.getRepositories()).thenReturn(repositories);
        context.registerService(IGithubRepoFetcher.class, repoFetcher);
        context.registerInjectActivateService(githubSightlyUseUnderTest);
        List<String> githubRepositories = githubSightlyUseUnderTest.getRepositories();
        Assert.assertNotNull(githubRepositories);
        Assert.assertSame(repositories, githubRepositories);
        Assert.assertEquals(10, githubRepositories.size());
    }

}

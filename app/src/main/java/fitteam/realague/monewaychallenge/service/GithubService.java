package fitteam.realague.monewaychallenge.service;

import java.util.List;

import fitteam.realague.monewaychallenge.model.Branch;
import fitteam.realague.monewaychallenge.model.Contributor;
import fitteam.realague.monewaychallenge.model.RepositoryResearchResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubService {

    @GET("search/repositories")
    Single<RepositoryResearchResponse> searchRepos(@Query("q") String research);

    @GET("repos/{name}/{repo}/branches")
    Single<List<Branch>> getBranches(@Path("name") String name, @Path("repo") String repo);

    @GET("repos/{name}/{repo}/contributors")
    Single<List<Contributor>> getContributors(@Path("name") String name, @Path("repo") String repo);

}

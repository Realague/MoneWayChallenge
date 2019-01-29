package fitteam.realague.monewaychallenge.application;

import android.app.Application;

import fitteam.realague.monewaychallenge.service.ApiClient;
import fitteam.realague.monewaychallenge.service.GithubService;

public class ApplicationController extends Application {

    private static ApplicationController instance;

    private GithubService githubService;

    @Override
    public void onCreate() {
        super.onCreate();

        githubService = ApiClient.getClient(getApplicationContext()).create(GithubService.class);

        instance = this;
    }

    public static ApplicationController getInstance() {
        return instance;
    }

    public GithubService getGithubService() {
        return githubService;
    }
}

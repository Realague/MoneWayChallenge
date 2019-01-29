package fitteam.realague.monewaychallenge.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TableRow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import fitteam.realague.monewaychallenge.R;
import fitteam.realague.monewaychallenge.adapter.BranchAdapter;
import fitteam.realague.monewaychallenge.adapter.ContributorAdapter;
import fitteam.realague.monewaychallenge.adapter.RepositoryAdapter;
import fitteam.realague.monewaychallenge.application.ApplicationController;
import fitteam.realague.monewaychallenge.databinding.ActivityRepositoryBinding;
import fitteam.realague.monewaychallenge.handler.ClickHandlers;
import fitteam.realague.monewaychallenge.model.Branch;
import fitteam.realague.monewaychallenge.model.Contributor;
import fitteam.realague.monewaychallenge.model.Repository;
import fitteam.realague.monewaychallenge.model.RepositoryResearchResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class RepositoryActivity extends AppCompatActivity {

    private String TAG = "RepositoryActivity";
    private RecyclerView contributorRecyclerView;
    private RecyclerView branchRecyclerView;
    private ActivityRepositoryBinding binding;
    private ContributorAdapter adapterContributor;
    private BranchAdapter adapterBranch;
    private CompositeDisposable disposable = new CompositeDisposable();
    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Gson gson = new GsonBuilder().create();
        repository = gson.fromJson(intent.getStringExtra("repository"), Repository.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_repository);

        String username = repository.getFullName().substring(0, repository.getFullName().indexOf('/'));
        String repo = repository.getFullName().substring(repository.getFullName().indexOf('/') + 1, repository.getFullName().length());
        Log.d(TAG, username);
        Log.d(TAG, repo);

        disposable.add(ApplicationController.getInstance().getGithubService()
                .getContributors(username, repo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Contributor>>() {
                    @Override
                    public void onSuccess(List<Contributor> contributors) {
                        setContributorAdapter(contributors);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Request", "onError: " + e.getMessage());
                    }
                })
        );

        disposable.add(ApplicationController.getInstance().getGithubService()
                .getBranches(username, repo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Branch>>() {
                    @Override
                    public void onSuccess(List<Branch> branches) {
                        setBranchAdapter(branches);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Request", "onError: " + e.getMessage());
                    }
                })
        );
    }

    public void setContributorAdapter(List<Contributor> contributors) {
        contributorRecyclerView = binding.contributorRecyclerView;
        contributorRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        contributorRecyclerView.setNestedScrollingEnabled(false);
        adapterContributor = new ContributorAdapter(this, contributors);
        contributorRecyclerView.setAdapter(adapterContributor);
    }

    public void setBranchAdapter(List<Branch> branches) {
        branchRecyclerView = binding.branchRecyclerView;
        branchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        branchRecyclerView.setNestedScrollingEnabled(false);
        adapterBranch = new BranchAdapter(this, branches);
        branchRecyclerView.setAdapter(adapterBranch);
    }
}

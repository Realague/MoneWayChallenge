package fitteam.realague.monewaychallenge.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import fitteam.realague.monewaychallenge.R;
import fitteam.realague.monewaychallenge.adapter.RepositoryAdapter;
import fitteam.realague.monewaychallenge.databinding.ActivityMainBinding;
import fitteam.realague.monewaychallenge.handler.ClickHandlers;
import fitteam.realague.monewaychallenge.model.Repository;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity implements RepositoryAdapter.RepositoryAdapterListener {

    private String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private ActivityMainBinding binding;
    private RepositoryAdapter adapter;
    private static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        instance = this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHandlers(new ClickHandlers());
    }

    public void setAdapter(List<Repository> repositories) {
        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new RepositoryAdapter(this, repositories, this);
        recyclerView.setAdapter(adapter);
    }

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    public void onRepositoryClicked(Repository repository) {
        Intent intent = new Intent(this, RepositoryActivity.class);
        Gson gson = new GsonBuilder().create();
        intent.putExtra("repository", gson.toJson(repository));
        this.startActivity(intent);
    }
}

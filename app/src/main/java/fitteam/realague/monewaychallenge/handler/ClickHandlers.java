package fitteam.realague.monewaychallenge.handler;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import fitteam.realague.monewaychallenge.R;
import fitteam.realague.monewaychallenge.activity.MainActivity;
import fitteam.realague.monewaychallenge.application.ApplicationController;
import fitteam.realague.monewaychallenge.model.RepositoryResearchResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ClickHandlers {

    private CompositeDisposable disposable = new CompositeDisposable();

    public ClickHandlers() {
    }

    public void onResearchButtonClicked(View view) {
        EditText editText = view.getRootView().findViewById(R.id.research);
        String text = editText.getText().toString();
        if (text.equals("")) {
            return;
        }
        final Animation anim = AnimationUtils.loadAnimation(view.getContext(), R.anim.rotate);
        view.startAnimation(anim);

        disposable.add(ApplicationController.getInstance().getGithubService()
                .searchRepos(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RepositoryResearchResponse>() {
                    @Override
                    public void onSuccess(RepositoryResearchResponse repositoryResearchResponse) {
                        MainActivity.getInstance().setAdapter(repositoryResearchResponse.getRepositories());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Request", "onError: " + e.getMessage());
                    }
                })
        );
    }

}

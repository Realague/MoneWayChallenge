package fitteam.realague.monewaychallenge.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fitteam.realague.monewaychallenge.R;
import fitteam.realague.monewaychallenge.databinding.RepositoryRowItemBinding;
import fitteam.realague.monewaychallenge.holder.RepositoryViewHolder;
import fitteam.realague.monewaychallenge.model.Repository;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryViewHolder> {

    private List<Repository> repositories;
    private LayoutInflater layoutInflater;
    private RepositoryAdapterListener listener;



    public RepositoryAdapter(Context context, List<Repository> repositories, RepositoryAdapterListener listener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.repositories = repositories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RepositoryRowItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.repository_row_item, parent, false);
        return new RepositoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, final int position) {
        holder.getBinding().setRepository(repositories.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onRepositoryClicked(repositories.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public interface RepositoryAdapterListener {
        void onRepositoryClicked(Repository repository);
    }
}

package fitteam.realague.monewaychallenge.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import fitteam.realague.monewaychallenge.R;
import fitteam.realague.monewaychallenge.databinding.ContributorRowItemBinding;
import fitteam.realague.monewaychallenge.holder.ContributorViewHolder;
import fitteam.realague.monewaychallenge.model.Contributor;

public class ContributorAdapter extends RecyclerView.Adapter<ContributorViewHolder> {

    private List<Contributor> contributors;
    private LayoutInflater layoutInflater;

    public ContributorAdapter(Context context, List<Contributor> contributors) {
        this.layoutInflater = LayoutInflater.from(context);
        this.contributors = contributors;
    }

    @NonNull
    @Override
    public ContributorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContributorRowItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.contributor_row_item, parent, false);
        return new ContributorViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContributorViewHolder holder, final int position) {
        holder.getBinding().setContributor(contributors.get(position));
    }

    @Override
    public int getItemCount() {
        return contributors.size();
    }

}

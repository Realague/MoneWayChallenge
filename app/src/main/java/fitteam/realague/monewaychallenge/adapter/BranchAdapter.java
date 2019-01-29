package fitteam.realague.monewaychallenge.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import fitteam.realague.monewaychallenge.R;
import fitteam.realague.monewaychallenge.databinding.BranchRowItemBinding;
import fitteam.realague.monewaychallenge.databinding.RepositoryRowItemBinding;
import fitteam.realague.monewaychallenge.holder.BranchViewHolder;
import fitteam.realague.monewaychallenge.model.Branch;

public class BranchAdapter extends RecyclerView.Adapter<BranchViewHolder> {

    private List<Branch> branches;
    private LayoutInflater layoutInflater;

    public BranchAdapter(Context context, List<Branch> branches) {
        this.layoutInflater = LayoutInflater.from(context);
        this.branches = branches;
    }

    @NonNull
    @Override
    public BranchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BranchRowItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.branch_row_item, parent, false);
        return new BranchViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BranchViewHolder holder, final int position) {
        holder.getBinding().setBranch(branches.get(position));
    }

    @Override
    public int getItemCount() {
        return branches.size();
    }

}


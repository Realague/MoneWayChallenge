package fitteam.realague.monewaychallenge.holder;

import android.support.v7.widget.RecyclerView;

import fitteam.realague.monewaychallenge.databinding.BranchRowItemBinding;

public class BranchViewHolder extends RecyclerView.ViewHolder {

    private final BranchRowItemBinding binding;

    public BranchViewHolder(final BranchRowItemBinding itemBinding) {
        super(itemBinding.getRoot());
        this.binding = itemBinding;
    }

    public BranchRowItemBinding getBinding() {
        return binding;
    }
}

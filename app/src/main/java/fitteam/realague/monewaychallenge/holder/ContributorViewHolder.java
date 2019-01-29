package fitteam.realague.monewaychallenge.holder;

import android.support.v7.widget.RecyclerView;

import fitteam.realague.monewaychallenge.databinding.ContributorRowItemBinding;

public class ContributorViewHolder extends RecyclerView.ViewHolder {

    private final ContributorRowItemBinding binding;

    public ContributorViewHolder(final ContributorRowItemBinding itemBinding) {
        super(itemBinding.getRoot());
        this.binding = itemBinding;
    }

    public ContributorRowItemBinding getBinding() {
        return binding;
    }
}

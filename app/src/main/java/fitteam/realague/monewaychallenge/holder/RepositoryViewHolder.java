package fitteam.realague.monewaychallenge.holder;

import android.support.v7.widget.RecyclerView;

import fitteam.realague.monewaychallenge.databinding.RepositoryRowItemBinding;

public class RepositoryViewHolder extends RecyclerView.ViewHolder {

    private final RepositoryRowItemBinding binding;

    public RepositoryViewHolder(final RepositoryRowItemBinding itemBinding) {
        super(itemBinding.getRoot());
        this.binding = itemBinding;
    }

    public RepositoryRowItemBinding getBinding() {
        return binding;
    }
}

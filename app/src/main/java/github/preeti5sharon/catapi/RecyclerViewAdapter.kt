package github.preeti5sharon.catapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import github.preeti5sharon.catapi.databinding.RvItemBinding
import github.preeti5sharon.catapi.model.CatResponseItem

class RecyclerViewAdapter :
    PagingDataAdapter<CatResponseItem, RecyclerView.ViewHolder>(diffCallback = CatDiffer()) {

    class CatDiffer : DiffUtil.ItemCallback<CatResponseItem>() {
        override fun areItemsTheSame(oldItem: CatResponseItem, newItem: CatResponseItem): Boolean {
            return newItem.id === oldItem.id
        }

        override fun areContentsTheSame(
            oldItem: CatResponseItem,
            newItem: CatResponseItem,
        ): Boolean {
            return newItem.id == oldItem.id
        }
    }

    class RvViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = RvItemBinding.bind(holder.itemView)
        val item = getItem(position)
        val url = item?.url
        binding.rvImage.load(url)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return RvViewHolder(view)
    }
}

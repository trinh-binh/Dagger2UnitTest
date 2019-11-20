package windy.dagger2unittest.ui.base.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *@trinh.binh on 16/01/2018
 *
 */
open abstract class BaseRecyclerViewAdapter<T>(ct: Context) : RecyclerView.Adapter<BaseRecyclerViewAdapter<T>.BaseViewHolder<T>>() {
    var list = ArrayList<T>()
    //var context : Context = ct

    fun clearList(){
        list.clear()
    }

    fun updateList(_list : List<T>){
        list.clear()
        list.addAll(_list)
        notifyDataSetChanged()
    }

    fun addToList(li : List<T>){
        list.addAll(li)
        notifyItemRangeInserted(list.size - li.size , li.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): BaseViewHolder<T> {
        return createVH(LayoutInflater.from(parent.context).inflate(getResItemId(),parent ,false), pos)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return getItemType(position)
    }

    override fun onBindViewHolder(holder : BaseViewHolder<T>, pos: Int){
        holder.bindView(list[pos])
    }

    abstract fun getResItemId() : Int
    abstract fun createVH(view : View, viewType: Int) : BaseViewHolder<T>
    abstract fun getItemType(pos: Int) : Int

    abstract inner class BaseViewHolder<K>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bindView(item : K)
    }
}
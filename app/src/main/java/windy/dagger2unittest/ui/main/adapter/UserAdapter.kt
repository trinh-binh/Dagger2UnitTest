package windy.dagger2unittest.ui.main.adapter

import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.user_item_layout.view.*
import windy.dagger2unittest.R
import windy.dagger2unittest.data.model.User
import windy.dagger2unittest.ui.base.view.BaseRecyclerViewAdapter

/**
 *@trinh.binh on 16/01/2018
 *
 */
class UserAdapter(ct : Context) : BaseRecyclerViewAdapter<User>(ct){
    lateinit var itemActionListener: ItemActionListener

    override fun getResItemId(): Int {
        return R.layout.user_item_layout
    }

    override fun getItemType(pos: Int): Int {
        return 1
    }

    override fun createVH(view: View, viewType: Int): BaseViewHolder<User> {
        return object : BaseViewHolder<User>(view){
            override fun bindView(item: User) {
                view.tv_id.text = item.id.toString()
                view.tv_name.text = item.name
                view.item_view.setOnClickListener {
                    itemActionListener.onClick(adapterPosition)
                }
            }

        }
    }

}
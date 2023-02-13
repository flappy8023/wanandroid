package com.flappy.wanandroid.ui.mine.history

import com.flappy.wanandroid.R
import com.flappy.wanandroid.base.BaseVMFragment
import com.flappy.wanandroid.databinding.CommonListFragmentBinding
import com.flappy.wanandroid.ext.goArticleDetail

/**
 * @Author: luweiming
 * @Description:
 * @Date: Created in 17:41 2022/12/7
 */
class ReadHistoryFragment : BaseVMFragment<CommonListFragmentBinding, ReadHistoryVM>() {
    private val adapter: ReadHistoryAdapter by lazy { ReadHistoryAdapter() }

    override fun initView() {
        binding.recyclerView.adapter = adapter
        adapter.itemClick = { p, data -> goArticleDetail(data.title, data.link) }
    }

    override fun getLayoutId(): Int = R.layout.common_list_fragment
    override fun bindViewModel() {
        viewModel.histories.observe(this) {
            adapter.addAll(it)
        }
    }
}
package com.aoh404.concatadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ConcatAdapter
import com.aoh404.concatadapter.adapter.AddContentAdapter
import com.aoh404.concatadapter.adapter.HeadlineAdapter
import com.aoh404.concatadapter.adapter.TitleAdapter
import com.aoh404.concatadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var index = 0

    private val firstTitleAdapter by lazy { TitleAdapter() }

    private val secondTitleAdapter by lazy { TitleAdapter() }

    private val firstHeadlineAdapter by lazy { HeadlineAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val config = ConcatAdapter.Config.Builder()
            .setIsolateViewTypes(false)
            .build()

        val secondHeadlineAdapter = HeadlineAdapter()
        val concatAdapter = ConcatAdapter(
            config,
            firstTitleAdapter,
            firstHeadlineAdapter,
            AddContentAdapter(),
            secondTitleAdapter,
            secondHeadlineAdapter,
            AddContentAdapter()
        )
        dataBinding.rvContainer.adapter = concatAdapter
        secondHeadlineAdapter.submitList(List(10) { "$it First Headline: $index" })
    }

    fun updateFirstTitle(view: View) {
        ++index
        firstTitleAdapter.data = "Update first title: $index"
    }

    fun updateSecondTitle(view: View) {
        ++index
        secondTitleAdapter.data = "Update second title: $index"
    }

    fun updateHeadline(view: View) {
        ++index
        firstHeadlineAdapter.submitList(List(10) { "$it Second Headline: $index" })
    }

    fun singleHeadline(view: View) {
        ++index
        val list = firstHeadlineAdapter.currentList.toMutableList()
            .apply {
                set(5, "Update single headline in FirstHeadlineAdapter: $index")
            }
        firstHeadlineAdapter.submitList(list)
    }
}
package com.techyourchance.dagger2course.screens.questiondetails

import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.questions.Question
import com.techyourchance.dagger2course.questions.QuestionWithBody
import com.techyourchance.dagger2course.screens.common.imageloader.ImageLoader
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar
import com.techyourchance.dagger2course.screens.common.viewsmvc.BaseViewMvc

class QuestionDetailsViewMvc(
        layoutInflater: LayoutInflater,
        private val imageLoader: ImageLoader,
        parent: ViewGroup?
) : BaseViewMvc<QuestionDetailsViewMvc.Listener>(
        layoutInflater, parent,
        R.layout.layout_question_details) {
    interface Listener {
        fun onBackClicked()
    }

    private val toolbar: MyToolbar = findViewById(R.id.toolbar)
    private val swipeRefresh: SwipeRefreshLayout
    private val txtQuestionBody: TextView = findViewById(R.id.txt_question_body)
    private val imgUser: ImageView = findViewById(R.id.img_user)
    private val txtUserName: TextView = findViewById(R.id.txt_user_name)

    init {

        // init toolbar
        toolbar.setNavigateUpListener {
            for (listener in listeners) {
                listener.onBackClicked()
            }
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }

    fun setQuestionBodyText(text: Spanned) {
        findViewById<TextView>(R.id.txt_question_body).text = text
    }

    fun bindQuestionWithBody(question: QuestionWithBody){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            setQuestionBodyText(Html.fromHtml(question.body, Html.FROM_HTML_MODE_LEGACY))
        } else {
            @Suppress("DEPRECATION")
            setQuestionBodyText(Html.fromHtml(question.body))
        }
        imageLoader.loadImage(question.owner.imageUrl, imgUser)
        txtUserName.text = question.owner.name
    }
}
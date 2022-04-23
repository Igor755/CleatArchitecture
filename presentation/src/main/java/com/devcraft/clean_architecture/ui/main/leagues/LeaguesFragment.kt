package com.devcraft.clean_architecture.ui.main.leagues

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.devcraft.clean_architecture.R
import com.devcraft.clean_architecture.common.BaseFragment
import com.devcraft.clean_architecture.extension.getErrorMessageFromException
import com.devcraft.clean_architecture.ui.main.MainActivity
import com.devcraft.clean_architecture.ui.main.leagues.adapter.LeaguesAdapter
import com.devcraft.clean_architecture.ui.main.leagues.vm.LeaguesViewModel
import com.devcraft.domain.model.Result
import kotlinx.android.synthetic.main.fragment_leagues.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LeaguesFragment : BaseFragment(R.layout.fragment_leagues)  {

    private val leaguesAdapter: LeaguesAdapter by inject()
    private val leaguesViewModel: LeaguesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        initListeners()
    }

    fun initViews(){
        rvLeagues.adapter = leaguesAdapter
    }

    fun initListeners(){

    }

    fun initObservers(){
        leaguesViewModel.getLeaguesFromServer()
        leaguesViewModel.leaguesLiveData.observe(viewLifecycleOwner, Observer { result->
            when(result){
                is Result.Success->{
                    if (result.data?.league?.isNotEmpty()!!) {
                        leaguesAdapter.setNewData(result.data!!.league)
                    }
                }
                is Result.Error->{
                    context?.getErrorMessageFromException(
                        result.exception,
                        root,
                        onNetworkError = { (activity as? MainActivity)?.showNoInternetDialog()
                            setOnConnectionChangeListener {
                                if (it) {
                                    leaguesViewModel.getLeaguesFromServer()
                                }
                            }
                        },
                        onBadUser = {
                            startActivity(Intent(activity, MainActivity::class.java).apply {
                                    flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                                })
                            activity?.finish()
                        })
                }
            }
        })
    }
}
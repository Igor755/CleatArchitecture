package com.devcraft.clean_architecture.ui.main.season

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.devcraft.clean_architecture.R
import com.devcraft.clean_architecture.common.BaseFragment
import com.devcraft.clean_architecture.extension.getErrorMessageFromException
import com.devcraft.clean_architecture.ui.main.MainActivity
import com.devcraft.clean_architecture.ui.main.season.adapter.SeasonAdapter
import com.devcraft.clean_architecture.ui.main.season.vm.SeasonViewModel
import com.devcraft.domain.model.Result
import kotlinx.android.synthetic.main.fragment_leagues.root
import kotlinx.android.synthetic.main.fragment_season.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SeasonFragment : BaseFragment(R.layout.fragment_season)  {

    private val seasonViewModel: SeasonViewModel by viewModel()
    var idLeague = "0"
    private val seasonAdapter: SeasonAdapter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments?.getString("id") != null) {
            idLeague = (arguments?.getString("id")!!)
        }
        initViews()
        initObservers()
        initListeners()
    }

    fun initViews(){
        rvSeasons.adapter = seasonAdapter
    }

    fun initListeners(){

    }

    fun initObservers(){
        seasonViewModel.getSeasonFromServer(idLeague)
        seasonViewModel.seasonLiveData.observe(viewLifecycleOwner, Observer { result->
            when(result){
                is Result.Success->{
                    if (result.data?.data?.standings?.isNotEmpty()!!) {
                        seasonAdapter.setNewData(result.data!!.data.standings)
                    }
                }
                is Result.Error->{
                    context?.getErrorMessageFromException(
                        result.exception,
                        root,
                        onNetworkError = { (activity as? MainActivity)?.showNoInternetDialog()
                            setOnConnectionChangeListener {
                                if (it) {
                                    seasonViewModel.getSeasonFromServer(idLeague)
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
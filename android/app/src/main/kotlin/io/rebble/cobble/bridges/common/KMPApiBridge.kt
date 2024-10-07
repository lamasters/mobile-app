package io.rebble.cobble.bridges.common

import android.content.Intent
import io.rebble.cobble.FlutterMainActivity
import io.rebble.cobble.MainActivity
import io.rebble.cobble.bridges.FlutterBridge
import io.rebble.cobble.bridges.ui.BridgeLifecycleController
import io.rebble.cobble.pigeons.Pigeons
import io.rebble.cobble.shared.domain.state.CurrentToken
import io.rebble.cobble.shared.ui.nav.Routes
import kotlinx.coroutines.flow.MutableStateFlow
import timber.log.Timber
import javax.inject.Inject

class KMPApiBridge @Inject constructor(
        private val tokenState: MutableStateFlow<CurrentToken>,
        bridgeLifecycleController: BridgeLifecycleController,
        private val activity: FlutterMainActivity? = null
): FlutterBridge, Pigeons.KMPApi {

    init {
        bridgeLifecycleController.setupControl(Pigeons.KMPApi::setup, this)
    }

    override fun updateToken(token: Pigeons.StringWrapper) {
        tokenState.value = token.value?.let { CurrentToken.LoggedIn(it) } ?: CurrentToken.LoggedOut
    }

    override fun openLockerView() {
        activity?.let {
            Timber.d("Opening locker view")
            val intent = Intent(activity.context, MainActivity::class.java)
            intent.putExtra("navigationPath", Routes.Home.LOCKER_WATCHFACES)
            activity.startActivity(intent)
        }
    }
}
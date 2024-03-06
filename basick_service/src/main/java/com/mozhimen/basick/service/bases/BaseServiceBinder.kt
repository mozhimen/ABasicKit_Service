package com.mozhimen.basick.service.bases

import android.os.RemoteCallbackList
import com.mozhimen.basick.service.commons.IBaseServiceConnListener
import com.mozhimen.basick.service.commons.IBaseServiceResListener

/**
 * @ClassName BaseServiceBinder
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/6/10 20:12
 * @Version 1.0
 */
open class BaseServiceBinder(private var _listeners: RemoteCallbackList<IBaseServiceResListener>) : IBaseServiceConnListener.Stub() {
    override fun onServiceStart() {

    }

    override fun registerListener(listener: IBaseServiceResListener?) {
        listener?.let { _listeners.register(it) }
    }

    override fun launchCommand(cmd: String?): String {
        return ""
    }

    override fun unRegisterListener(listener: IBaseServiceResListener?) {
        listener?.let { _listeners.unregister(it) }
    }

    override fun onServiceStop() {
        _listeners.kill()
    }
}

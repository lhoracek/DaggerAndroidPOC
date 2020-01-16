package cz.lhoracek.myapplication.core.mocks.model

import cz.lhoracek.myapplication.core.model.ApiInterface


class OfflineAPI: ApiInterface {
    override fun getData() = "Hi I'm offline fake response"

}
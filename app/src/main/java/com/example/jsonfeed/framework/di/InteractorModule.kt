package com.example.jsonfeed.framework.di

import com.example.jsonfeed.data.LocalRepository
import com.example.jsonfeed.data.RemoteRepository

import com.example.jsonfeed.framework.Interactors
import com.example.jsonfeed.framework.datasource.db.RoomDataSource
import com.example.jsonfeed.framework.datasource.network.NetworkDataSource

import com.example.jsonfeed.interactors.GetLocalItem
import com.example.jsonfeed.interactors.GetLocalItems
import com.example.jsonfeed.interactors.GetRemoteItems
import com.example.jsonfeed.interactors.StoreItems

import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideInteractors(
        getLocalFeedItem: GetLocalItem,
        getLocalFeedItems: GetLocalItems,
        getRemoteFeed: GetRemoteItems,
        insertLocalFeedItems: StoreItems
    ): Interactors {
        return Interactors(
            getLocalFeedItem,
            getLocalFeedItems,
            getRemoteFeed,
            insertLocalFeedItems
        )
    }

    @Provides
    fun provideInteractorGetLocalFeedItem(
        dataSource: RoomDataSource
    ): GetLocalItem {
        return GetLocalItem(LocalRepository(dataSource))
    }

    @Provides
    fun provideInteractorGetLocalFeedItems(
        dataSource: RoomDataSource
    ): GetLocalItems {
        return GetLocalItems(LocalRepository(dataSource))
    }

    @Provides
    fun provideInteractorInsertLocalFeedItems(
        dataSource: RoomDataSource
    ): StoreItems {
        return StoreItems(LocalRepository(dataSource))
    }

    @Provides
    fun provideInteractorGetRemoteFeed(
        dataSource: NetworkDataSource
    ): GetRemoteItems {
        return GetRemoteItems(RemoteRepository(dataSource))
    }

}
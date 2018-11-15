package com.qilinxx.innovatevolume.service;

import com.qilinxx.innovatevolume.domain.model.Provider;

import java.util.List;

public interface ProviderService {
    /**查询所有的提供商 */
    List<Provider> selectAll();
}

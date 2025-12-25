package fun.guardianelf.shopping.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fun.guardianelf.shopping.mapper.AddressMapper;
import fun.guardianelf.shopping.domain.Address;
import fun.guardianelf.shopping.service.IAddressService;

/**
 * 地址Service业务层处理
 * 
 * @author pc
 * @date 2025-12-25
 */
@Service
public class AddressServiceImpl implements IAddressService 
{
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 查询地址
     * 
     * @param id 地址主键
     * @return 地址
     */
    @Override
    public Address selectAddressById(String id)
    {
        return addressMapper.selectAddressById(id);
    }

    /**
     * 查询地址列表
     * 
     * @param address 地址
     * @return 地址
     */
    @Override
    public List<Address> selectAddressList(Address address)
    {
        return addressMapper.selectAddressList(address);
    }

    /**
     * 新增地址
     * 
     * @param address 地址
     * @return 结果
     */
    @Override
    public int insertAddress(Address address)
    {
        return addressMapper.insertAddress(address);
    }

    /**
     * 修改地址
     * 
     * @param address 地址
     * @return 结果
     */
    @Override
    public int updateAddress(Address address)
    {
        return addressMapper.updateAddress(address);
    }

    /**
     * 批量删除地址
     * 
     * @param ids 需要删除的地址主键
     * @return 结果
     */
    @Override
    public int deleteAddressByIds(String[] ids)
    {
        return addressMapper.deleteAddressByIds(ids);
    }

    /**
     * 删除地址信息
     * 
     * @param id 地址主键
     * @return 结果
     */
    @Override
    public int deleteAddressById(String id)
    {
        return addressMapper.deleteAddressById(id);
    }
}

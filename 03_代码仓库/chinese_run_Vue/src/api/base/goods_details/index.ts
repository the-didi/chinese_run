import request from '/@/utils/request'
// 分页查询商品详细信息
export function findByPage(params:object){
    return request({
        url:'/admin/goods_details/info',
        method:'GET',
        params:params
    })
}
// 通过id查询商品信息
export function findById(params:object){
    return request({
        url:'/admin/goods_details/getById',
        method:'GET',
        params:params
    })
}
// 通过货主姓名查询商品详细信息
export function findByName(params:object){
    return request({
        url:'/admin/goods_details/getByName',
        method:'GET',
        params:params
    })
}
// 根据id删除商品详细信息
export function deleteById(params:object){
    return request({
        url:'/admin/goods_details/del',
        method:'DELETE',
        params:params
    })
}
// 修改商品详细信息
export function updateGoodsDetails(params:object){
    return request({
        url:'/admin/goods_details/update',
        method:'PUT',
        data:params
    })
}
// 添加商品详细信息
export function addGoodsDetails(params:object){
    return request({
        url:'/admin/goods_details/add',
        method:'POST',
        data:params
    })
}
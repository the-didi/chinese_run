import request from '/@/utils/request'

// 分页查询商品信息
export  function findByPage(params:object){
    return request({
        url:'/admin/base_goods/info',
        method:'GET',
        params:params
    })
}
// 按条件查询商品信息
export function findByName(params:object){
    return request({
        url:'/admin/base_goods/getByName',
        method: 'GET',
        params:params
    })
}
// 删除商品信息
export function deleteById(params:object) {
    return request({
        url:'/admin/base_goods/del',
        method:'DELETE',
        params:params
    })
}
// 修改商品信息
export function updateGoods(params:object) {
    return request({
        url :'/admin/base_goods/update',
        method:'PUT',
        data:params
    })
}
// 添加商品信息
export function addGoods(params:object){
    return request({
        url:'/admin/base_goods/add',
        method:'POST',
        data:params
    })
}
// 通过id查询商品信息
export function getById(params:object){
    return request({
        url:'/admin/base_goods/getById',
        method:'GET',
        params:params
    })
}
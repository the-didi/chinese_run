import request from '/@/utils/request'

// 分页查询商品信息
export  function findByPage(params:object){
    return request({
        url:'',
        method:'GET',
        params:params
    })
}
// 按条件查询商品信息
export function findByName(params:object){
    return request({
        url:'',
        method: 'GET',
        params:params
    })
}
// 删除商品信息
export function deleteById(params:object) {
    return request({
        url:'',
        method:'DELETE',
        params:params
    })
}
// 修改商品信息
export function updateGoods(params:object) {
    return request({
        url :'',
        method:'PUT',
        data:params
    })
}
// 添加商品信息
export function addGoods(params:object){
    return request({
        url:'',
        method:'POST',
        data:params
    })
}
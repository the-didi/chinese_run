import request from '/@/utils/request'
export function findByPage(params:object){
    return request({
        url: '/admin/transport/info',
        method: 'get',
        params: params
    })
}
// 编辑物流信息
export function updateTransport(params:object){
    return request({
        url:'/admin/transport/update',
        method : 'PUT',
        data:params
    })
}
//删除物流信息
export function deleteTransport(params:object){
    return request({
                url : '/admin/transport/del',
                method : 'DELETE',
                params:params
    })
}
//按条件查询物流信息
import request from '/@/utils/request'
export function findByPage(params:object){
    return request({
        url: '/admin/roles',
        method: 'get',
        params: params
    })
}
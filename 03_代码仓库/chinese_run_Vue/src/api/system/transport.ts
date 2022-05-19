import request from '/@/utils/request'
export function findByPage(params:object){
    return request({
        url: '/admin/transport/info',
        method: 'get',
        params: params
    })
}
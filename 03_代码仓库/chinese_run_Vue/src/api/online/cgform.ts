import request from '/@/utils/request'
export function findByPage(params: object){
    return request({
        url: '/online/cgForm',
        method: 'get',
        params:params
    })
}
import request from '/@/utils/request'
export function findByPage(params:object){
    return request({
        url: '/admin/otherstorage/info',
        method: 'get',
        params: params
    })
}
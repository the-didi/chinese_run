import request from '/@/utils/request'
// 分页
export function findByPage(params:object){
    return request({
        url: '/admin/driver/info',
        method: 'get',
        params: params
    })

}
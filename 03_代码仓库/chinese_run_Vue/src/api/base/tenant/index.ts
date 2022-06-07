import request from '/@/utils/request'
export function findByPage(params:object){
    return request({
        url: `/tenant/cr_tenant`,
        method: 'get',
        params: params
    })
}

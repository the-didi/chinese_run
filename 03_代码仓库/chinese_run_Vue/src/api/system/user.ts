import request from '/@/utils/request';
export function findByPage(params: object){
    return request({
        url: '/admin/sysUser',
        method: 'get',
        params: params
    })
}
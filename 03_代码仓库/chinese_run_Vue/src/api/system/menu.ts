import request from '/@/utils/request'
import { Session } from '/@/utils/storage'
export function getByPage(params:object){
    return request({
        url: '/admin/login',
        method: 'post',
        params: params
    })
}
export function getUserInfo(params: object){
    return request({
        url: '/admin/info',
        method: 'get',
        params: params
    })
}
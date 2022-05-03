import request from '/@/utils/request'
// 分页
export function findByPage(params:object){
    return request({
        url: '/admin/menus',
        method: 'get',
        params: params
    })
}
export function deleteMenuById(params:object){
    return request({
        url: '/admin/menus/del',
        method: 'delete',
        params: params
    })
}
export function addMenu(params:object){
    return request({
        url: '/admin/menus/add',
        method: 'post',
        data: params
    })
}
export function updateMenu(params:object){
    return request({
        url: '/admin/menus/update',
        method: 'put',
        data: params
    })
}
export function deleteByIds(params:object){
    return request({
        url:'/admin/menus/batchDel',
        method: 'delete',
        data: params
    })
}
export function getMenuById(params: object){
    return request({
        url: '/admin/menus/getById',
        method: 'get',
        params: params
    })
}
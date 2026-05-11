# Task Management App - Apifox 接口文档（基于当前 Controller/DTO 自动整理）

## 1. 基础信息

- Base URL: `{{baseUrl}}`
- 推荐环境：
  - `local`: `http://localhost:8080`
  - `dev`: `http://127.0.0.1:8080`

## 2. Apifox 环境变量建议

```text
baseUrl = http://localhost:8080
token = token
userId = 1
listId = 1
sectionId = 1
taskId = 1
tagId = 1
attachmentId = 1
dependencyId = 2
```

## 3. 认证与请求头

- 登录接口返回：`data.token`
- 除注册、登录外，绝大多数接口在后端方法签名中依赖 `@RequestAttribute("userId")`。
- 若你的项目后续接入拦截器，建议在 Apifox 全局请求头配置：
  - `Authorization: Bearer {{token}}`
- 当前代码中尚未看到 `Authorization -> userId` 的显式注入逻辑；若直接调用需要 `userId` 的接口，可能因缺少请求属性报错（需你在鉴权中间件中补齐）。

## 4. 统一响应结构

所有接口均包裹在 `ApiResponse<T>` 中：

```json
{
  "code": 200,
  "message": "success",
  "data": {}
}
```

失败示例：

```json
{
  "code": 400,
  "message": "错误信息",
  "data": null
}
```

---

## 5. 接口文档（可直接用于 Apifox）

> 说明：以下「预期响应体」为结构示例，字段来自当前 DTO；业务值请以运行结果为准。

### 5.1 用户 User

#### 5.1.1 注册
- `POST /api/v1/users/register`
- 请求体：
```json
{
  "username": "alice",
  "password": "123456"
}
```
- 预期响应体：
```json
{
  "code": 200,
  "message": "注册成功",
  "data": {
    "userId": 1,
    "username": "alice"
  }
}
```

#### 5.1.2 登录
- `POST /api/v1/users/login`
- 请求体：
```json
{
  "username": "alice",
  "password": "123456"
}
```
- 预期响应体：
```json
{
  "code": 200,
  "message": "登录成功",
  "data": {
    "userId": 1,
    "username": "alice",
    "token": "token"
  }
}
```

#### 5.1.3 退出登录
- `POST /api/v1/users/logout`
- 请求体：无
- 预期响应体：
```json
{
  "code": 200,
  "message": "退出登录成功",
  "data": null
}
```

#### 5.1.4 获取当前用户信息
- `GET /api/v1/users/me`
- 请求体：无
- 预期响应体：
```json
{
  "code": 200,
  "message": "获取用户信息成功",
  "data": {
    "userId": 1,
    "username": "testUser"
  }
}
```

#### 5.1.5 更新当前用户信息
- `PUT /api/v1/users/users/me`  (按当前 Controller 路由原样保留)
- 请求体：
```json
{
  "username": "new_name"
}
```
- 预期响应体：
```json
{
  "code": 200,
  "message": "更新用户信息成功",
  "data": {
    "userId": 1,
    "username": "new_name"
  }
}
```

### 5.2 清单 TaskList

#### 5.2.1 获取清单列表
- `GET /api/v1/lists`
- 请求体：无
- 预期响应体：
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "list": [
      {
        "listId": 1,
        "name": "工作"
      }
    ],
    "total": 1
  }
}
```

#### 5.2.2 创建清单
- `POST /api/v1/lists`
- 请求体：
```json
{
  "name": "工作"
}
```
- 预期响应体（`TaskListItemDTO`）：
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "listId": 1,
    "name": "工作"
  }
}
```

#### 5.2.3 获取清单详情
- `GET /api/v1/lists/{listId}`
- Path 参数：`listId`
- 请求体：无
- 预期响应体：同 `TaskListItemDTO`

#### 5.2.4 更新清单
- `PATCH /api/v1/lists/{listId}`
- 请求体：
```json
{
  "name": "工作-更新"
}
```
- 预期响应体：同 `TaskListItemDTO`

#### 5.2.5 删除清单
- `DELETE /api/v1/lists/{listId}`
- 请求体：无
- 预期响应体：`data = null`

### 5.3 分组 Section

#### 5.3.1 获取某清单下分组
- `GET /api/v1/lists/{listId}/sections`
- 预期响应体（`SectionListResponse`）：
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "list": [
      {
        "sectionId": 1,
        "name": "今日"
      }
    ],
    "total": 1
  }
}
```

#### 5.3.2 创建分组
- `POST /api/v1/lists/{listId}/sections`
- 请求体：
```json
{
  "name": "今日"
}
```
- 预期响应体：`SectionItemDTO`

#### 5.3.3 获取分组详情
- `GET /api/v1/sections/{sectionId}`
- 预期响应体：`SectionItemDTO`

#### 5.3.4 更新分组
- `PATCH /api/v1/sections/{sectionId}`
- 请求体：
```json
{
  "name": "本周"
}
```
- 预期响应体：`SectionItemDTO`

#### 5.3.5 删除分组
- `DELETE /api/v1/sections/{sectionId}`
- 预期响应体：`data = null`

### 5.4 标签 Tag

#### 5.4.1 获取标签列表
- `GET /api/v1/tags`
- 预期响应体（`TagListResponse`）：
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "list": [
      {
        "tagId": 1,
        "name": "紧急"
      }
    ],
    "total": 1
  }
}
```

#### 5.4.2 创建标签
- `POST /api/v1/tags`
- 请求体：
```json
{
  "name": "紧急"
}
```
- 预期响应体：`TagItemDTO`

#### 5.4.3 获取标签详情
- `GET /api/v1/tags/{tagId}`
- 预期响应体：`TagItemDTO`

#### 5.4.4 更新标签
- `PATCH /api/v1/tags/{tagId}`
- 请求体：
```json
{
  "name": "一般"
}
```
- 预期响应体：`TagItemDTO`

#### 5.4.5 删除标签
- `DELETE /api/v1/tags/{tagId}`
- 预期响应体：`data = null`

### 5.5 任务 Task

#### 5.5.1 查询任务列表
- `GET /api/v1/tasks?status=1&page=1&size=10`
- Query 参数：
  - `status`(可选, Integer)
  - `page`(默认 1)
  - `size`(默认 10)
- 预期响应体（`TaskListResponse`）：
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "list": [
      {
        "taskId": 1,
        "title": "写文档",
        "status": 1,
        "priority": 2,
        "progress": 50,
        "dueDate": "2026-05-07T23:59:59",
        "createdAt": "2026-05-07T11:00:00"
      }
    ],
    "total": 1,
    "page": 1,
    "size": 10
  }
}
```

#### 5.5.2 创建任务
- `POST /api/v1/tasks`
- 请求体（`TaskCreateRequest`）：
```json
{
  "title": "新任务",
  "content": "任务内容",
  "priority": 2
}
```
- 预期响应体：`TaskItemDTO`

#### 5.5.3 获取任务详情
- `GET /api/v1/tasks/{taskId}`
- 预期响应体：`TaskItemDTO`

#### 5.5.4 更新任务
- `PATCH /api/v1/tasks/{taskId}`
- 请求体（`TaskUpdateRequest`）：
```json
{
  "title": "更新后的标题",
  "content": "更新后的内容",
  "priority": 1,
  "status": 1,
  "progress": 80,
  "dueDate": "2026-05-08T18:00:00"
}
```
- 预期响应体：`TaskItemDTO`

#### 5.5.5 删除任务
- `DELETE /api/v1/tasks/{taskId}`
- 预期响应体：`data = null`

#### 5.5.6 批量删除任务
- `DELETE /api/v1/tasks/batch-delete`
- 请求体：
```json
{
  "taskIds": [1, 2, 3]
}
```
- 预期响应体：`data = null`

#### 5.5.7 批量更新任务
- `PATCH /api/v1/tasks/batch-update`
- 请求体：
```json
{
  "taskIds": [1, 2],
  "title": "批量标题",
  "content": "批量内容",
  "status": 1,
  "priority": 2,
  "progress": 70,
  "dueDate": "2026-05-10T10:00:00"
}
```
- 预期响应体：`data = null`

#### 5.5.8 条件搜索任务
- `POST /api/v1/tasks/search`
- 请求体（`TaskQueryRequest`）：
```json
{
  "keyword": "文档",
  "status": 1,
  "priority": 2,
  "tagIds": [1, 2],
  "listId": 1,
  "sectionId": 1,
  "dueDateStart": "2026-05-01T00:00:00",
  "dueDateEnd": "2026-05-31T23:59:59",
  "sortBy": "createdAt",
  "sortOrder": "desc",
  "page": 1,
  "size": 10
}
```
- 预期响应体：`TaskListResponse`

#### 5.5.9 向量搜索任务
- `POST /api/v1/tasks/vector-search`
- 请求体（`TaskVectorSearchRequest`）：
```json
{
  "query": "本周重要任务",
  "topK": 10,
  "threshold": 0.6,
  "status": 1,
  "priority": 1,
  "tagIds": [1],
  "page": 1,
  "size": 10
}
```
- 预期响应体：`TaskListResponse`

#### 5.5.10 更新任务状态
- `PATCH /api/v1/tasks/{taskId}/status`
- 请求体：
```json
{
  "status": 2
}
```
- 预期响应体：`TaskItemDTO`

#### 5.5.11 标记完成
- `PATCH /api/v1/tasks/{taskId}/complete`
- 请求体：无
- 预期响应体：`TaskItemDTO`

#### 5.5.12 取消完成
- `PATCH /api/v1/tasks/{taskId}/uncomplete`
- 请求体：无
- 预期响应体：`TaskItemDTO`

#### 5.5.13 更新进度
- `PATCH /api/v1/tasks/{taskId}/progress`
- 请求体：
```json
{
  "progress": 85
}
```
- 预期响应体：`TaskItemDTO`

#### 5.5.14 更新优先级
- `PATCH /api/v1/tasks/{taskId}/priority`
- 请求体：
```json
{
  "priority": 1
}
```
- 预期响应体：`TaskItemDTO`

#### 5.5.15 批量更新优先级
- `PATCH /api/v1/tasks/batch-priority`
- 请求体：
```json
{
  "taskIds": [1, 2, 3],
  "priority": 2
}
```
- 预期响应体：`data = null`

#### 5.5.16 更新排序
- `PATCH /api/v1/tasks/{taskId}/order`
- 请求体：
```json
{
  "sortOrder": 10
}
```
- 预期响应体：`TaskItemDTO`

#### 5.5.17 批量重排
- `PATCH /api/v1/tasks/reorder`
- 请求体：
```json
{
  "items": [
    { "taskId": 1, "sortOrder": 1 },
    { "taskId": 2, "sortOrder": 2 }
  ]
}
```
- 预期响应体：`data = null`

#### 5.5.18 更新父任务
- `PATCH /api/v1/tasks/{taskId}/parent`
- 请求体：
```json
{
  "parentTaskId": 100
}
```
- 预期响应体：`TaskItemDTO`

#### 5.5.19 获取子任务
- `GET /api/v1/tasks/{taskId}/subtasks`
- 预期响应体：`TaskListResponse`

#### 5.5.20 创建子任务
- `POST /api/v1/tasks/{taskId}/subtasks`
- 请求体：同 `TaskCreateRequest`
- 预期响应体：`TaskItemDTO`

#### 5.5.21 获取任务依赖
- `GET /api/v1/tasks/{taskId}/dependencies`
- 预期响应体：`TaskListResponse`

#### 5.5.22 新增任务依赖
- `POST /api/v1/tasks/{taskId}/dependencies`
- 请求体：
```json
{
  "dependencyTaskId": 2
}
```
- 预期响应体：`data = null`

#### 5.5.23 删除任务依赖
- `DELETE /api/v1/tasks/{taskId}/dependencies/{dependencyId}`
- 预期响应体：`data = null`

#### 5.5.24 检查依赖环
- `POST /api/v1/tasks/{taskId}/dependencies/check-cycle`
- 请求体：
```json
{
  "dependencyTaskId": 2
}
```
- 预期响应体（`TaskDependencyCycleCheckResponse`）：
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "hasCycle": false,
    "message": "no cycle"
  }
}
```

#### 5.5.25 回收站列表
- `GET /api/v1/tasks/trash`
- 预期响应体：`TaskListResponse`

#### 5.5.26 恢复任务
- `POST /api/v1/tasks/{taskId}/restore`
- 预期响应体：`TaskItemDTO`

#### 5.5.27 彻底删除任务
- `DELETE /api/v1/tasks/{taskId}/permanent`
- 预期响应体：`data = null`

#### 5.5.28 清空回收站
- `POST /api/v1/tasks/trash/empty`
- 预期响应体：`data = null`

#### 5.5.29 给任务添加标签
- `POST /api/v1/tasks/{taskId}/tags`
- 请求体：
```json
{
  "tagId": 1
}
```
- 预期响应体：`data = null`

#### 5.5.30 删除任务标签
- `DELETE /api/v1/tasks/{taskId}/tags/{tagId}`
- 预期响应体：`data = null`

#### 5.5.31 批量移动任务
- `POST /api/v1/tasks/batch-move`
- 请求体：
```json
{
  "taskIds": [1, 2],
  "targetListId": 10,
  "targetSectionId": 20
}
```
- 预期响应体：`data = null`

#### 5.5.32 移动单个任务
- `PATCH /api/v1/tasks/{taskId}/move`
- 请求体：
```json
{
  "targetListId": 10,
  "targetSectionId": 20
}
```
- 预期响应体：`TaskItemDTO`

### 5.6 附件 Attachment

#### 5.6.1 获取任务附件列表
- `GET /api/v1/tasks/{taskId}/attachments`
- 预期响应体（`AttachmentListResponse`）：
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "list": [
      {
        "attachmentId": 1,
        "fileName": "design.png",
        "fileType": "image/png",
        "url": "https://example.com/design.png"
      }
    ],
    "total": 1
  }
}
```

#### 5.6.2 给任务新增附件（URL）
- `POST /api/v1/tasks/{taskId}/attachments`
- 请求体（`AttachmentCreateRequest`）：
```json
{
  "fileName": "design.png",
  "fileType": "image/png",
  "url": "https://example.com/design.png"
}
```
- 预期响应体：`AttachmentItemDTO`

#### 5.6.3 获取附件详情
- `GET /api/v1/attachments/{attachmentId}`
- 预期响应体：`AttachmentItemDTO`

#### 5.6.4 删除附件
- `DELETE /api/v1/attachments/{attachmentId}`
- 预期响应体：`data = null`

#### 5.6.5 上传附件文件（multipart）
- `POST /api/v1/attachments/upload`
- `Content-Type: multipart/form-data`
- 表单字段：
  - `file`: 文件（二进制）
- 预期响应体：`AttachmentItemDTO`

#### 5.6.6 创建外链附件
- `POST /api/v1/attachments/external-link`
- 请求体（`AttachmentExternalLinkRequest`）：
```json
{
  "fileName": "Figma设计稿",
  "url": "https://www.figma.com/file/xxx",
  "platform": "figma"
}
```
- 预期响应体：`AttachmentItemDTO`

#### 5.6.7 预览附件
- `GET /api/v1/attachments/{attachmentId}/preview`
- 预期响应体（`AttachmentPreviewResponse`）：
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "attachmentId": 1,
    "fileName": "design.png",
    "previewUrl": "https://example.com/preview/design.png",
    "previewType": "image"
  }
}
```

### 5.7 任务链接 TaskLink

#### 5.7.1 获取任务链接列表
- `GET /api/v1/tasks/{taskId}/links`
- 预期响应体（`TaskLinkListResponse`）：
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "list": [
      {
        "linkId": 1,
        "title": "需求文档",
        "url": "https://example.com/doc"
      }
    ],
    "total": 1
  }
}
```

---

## 6. Apifox 文件夹层级与嵌套关系（建议）

```text
Task Management App
├── 00-Auth与用户
│   ├── 用户注册
│   ├── 用户登录
│   ├── 退出登录
│   ├── 获取当前用户
│   └── 更新当前用户
│
├── 01-清单 Lists
│   ├── 获取清单列表
│   ├── 创建清单
│   ├── 获取清单详情
│   ├── 更新清单
│   ├── 删除清单
│   └── 分组 Sections（子目录）
│       ├── 获取清单下分组
│       └── 创建分组
│
├── 02-分组 Sections（全局）
│   ├── 获取分组详情
│   ├── 更新分组
│   └── 删除分组
│
├── 03-标签 Tags
│   ├── 获取标签列表
│   ├── 创建标签
│   ├── 获取标签详情
│   ├── 更新标签
│   └── 删除标签
│
├── 04-任务 Tasks
│   ├── 基础CRUD
│   │   ├── 查询任务列表
│   │   ├── 创建任务
│   │   ├── 获取任务详情
│   │   ├── 更新任务
│   │   └── 删除任务
│   ├── 批量操作
│   │   ├── 批量删除
│   │   ├── 批量更新
│   │   ├── 批量更新优先级
│   │   └── 批量移动
│   ├── 搜索
│   │   ├── 条件搜索
│   │   └── 向量搜索
│   ├── 状态与进度
│   │   ├── 更新状态
│   │   ├── 标记完成
│   │   ├── 取消完成
│   │   ├── 更新进度
│   │   └── 更新优先级
│   ├── 排序与层级
│   │   ├── 更新排序
│   │   ├── 批量重排
│   │   ├── 更新父任务
│   │   ├── 获取子任务
│   │   └── 创建子任务
│   ├── 依赖关系
│   │   ├── 获取依赖
│   │   ├── 新增依赖
│   │   ├── 删除依赖
│   │   └── 检查依赖环
│   ├── 回收站
│   │   ├── 回收站列表
│   │   ├── 恢复任务
│   │   ├── 彻底删除
│   │   └── 清空回收站
│   ├── 标签关系
│   │   ├── 添加任务标签
│   │   └── 删除任务标签
│   └── 位置移动
│       └── 移动单个任务
│
├── 05-附件 Attachments
│   ├── 任务附件
│   │   ├── 获取任务附件列表
│   │   └── 给任务新增附件(URL)
│   ├── 附件管理
│   │   ├── 获取附件详情
│   │   ├── 删除附件
│   │   ├── 上传附件文件
│   │   ├── 创建外链附件
│   │   └── 预览附件
│
└── 06-任务链接 TaskLinks
    └── 获取任务链接列表
```

## 7. Apifox 导入/调试建议

- 先跑通 `注册 -> 登录`，把 `data.token` 写入环境变量 `token`。
- 再按资源创建顺序调试：`List -> Section -> Task -> Tag -> Attachment/Link`。
- 需要路径参数的接口，统一使用上面的环境变量（如 `{{taskId}}`）。
- 涉及 `LocalDateTime` 字段时，统一使用 ISO8601：`yyyy-MM-dd'T'HH:mm:ss`。


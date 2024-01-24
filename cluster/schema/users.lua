local user = {}

function articles.init()
    local space = box.schema.space.create("users", { if_not_exists = true })
    space:format({
        { name = "login", type = "string" },
        { name = "fio", type = "string", is_nullable = true },
        { name = "id", type = "unsigned" },
    })

    space:create_index("primary", { parts = { { field = "login" } },
                                    if_not_exists = true })
end

return articles
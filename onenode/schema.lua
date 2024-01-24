local schema = {}

function schema.init()
    box.once('schema', function()
        require("schema/users").init()
    end)
end

return schema
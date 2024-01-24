function findUserByLogin(name)
  return box.space.users:select(name)
end
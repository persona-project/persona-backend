package me.tanglizi.persona.entity

import java.sql.Date

case class User(id: Int,
                name: String,
                birth: Date,
                sex: String,
                area: String,
                lastLoginTime: Date,
                termId: Int,
                courseId: Int,
                selectCourseTime: Date)

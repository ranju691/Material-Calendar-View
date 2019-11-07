@file:JvmName("EventDayUtils")

package com.applandeo.materialcalendarview.utils

import java.util.*

/**
 * This method is used to check whether this day is an event day with provided custom label color.
 *
 * @param this                A calendar instance representing day date
 * @param calendarProperties A calendar properties
 */
fun Calendar.isEventDayWithLabelColor(calendarProperties: CalendarProperties) =
        if (calendarProperties.eventsEnabled) {
        calendarProperties.eventDays.none { eventDate ->
            eventDate.calendar == this && eventDate.labelColor != 0
        }
    } else false

/**
 * This method is used to get event day which contains custom label color.
 *
 * @param this                A calendar instance representing day date
 * @param calendarProperties A calendar properties
 */
fun Calendar.getEventDayWithLabelColor(calendarProperties: CalendarProperties) =
        calendarProperties.eventDays
                .find { eventDate ->
                    eventDate.calendar != null && eventDate.calendar == this && eventDate.labelColor != 0
                }
